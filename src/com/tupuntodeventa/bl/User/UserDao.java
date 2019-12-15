package com.tupuntodeventa.bl.User;

import com.tupuntodeventa.bl.Direction.Direction;
import com.tupuntodeventa.dl.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUser {
    private DataAccess dataAccess = new DataAccess();
    @Override
    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        String queryString = "SELECT * FROM User";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                users.add(createUser(result));
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return users;
    }

    @Override
    public String save(User user) throws Exception {
        String message = "Error";

        String queryString = "INSERT INTO User(id, name, lastName1, lastName2, userName, email, pass, born, gender, userType, phone";

        String queryValues = ") VALUES("+ user.getId() +", '"+ user.getName() +"', '"+ user.getLastName1() +"', '"+ user.getLastName2() +"', " +
                "'"+ user.getUserName() +"', '"+ user.getEmail() + "', '"+ user.getPass() +"', '"+ user.getBorn() +"', '"+ user.getGender() +"', " +
                "'"+ user.getUserType() +"', '"+ user.getPhone() +"'";

        if(user.getUserType() == "Empleado" && user instanceof Employee){
            queryString += ", position";
            Employee employee = (Employee) user;
            queryValues += ", '"+ employee.getPosition().getName() +"'";
        }

        queryValues += ")";
        try {
            message = dataAccess.insertData(queryString+queryValues);
            if(user.getUserType() == "Cliente" && user instanceof Client){
                List<Direction> directions = ((Client) user).getDirections();
                for (Direction direction:directions) {
                    queryString = "INSERT INTO Direction (exactAddress, district, canton, province, kilometersToRestaurant, idUser) " +
                            "VALUES('"+direction.getExactAddress()+"','"+direction.getDistrict()+"','"+direction.getCanton()+"','" +
                            ""+direction.getProvince()+"','"+direction.getKilometersToRestaurant()+"',"+user.getId()+")";
                    message = dataAccess.insertData(queryString);
                }

            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return message;
    }

    @Override
    public boolean isAdminOnDB() throws Exception {
        int count = 0;
        String queryString = "SELECT id FROM User " +
                "WHERE userType = 'Administrador'";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                count++;
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return count > 0;
    }

    @Override
    public User login(String userName, String pass) throws Exception {
        int count = 0;
        User user = null;
        String queryString = "SELECT * FROM User " +
                "WHERE userName = '"+ userName +"' AND pass = '"+ pass +"'";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                user = createUser(result);
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return user;
    }

    @Override
    public User getById(User user) throws Exception {
        User userResult = null;
        String queryString = "SELECT * FROM User " +
                "WHERE id = "+user.getId()+"";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                userResult = createUser(result);
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return userResult;
    }

    private User createUser(ResultSet result) throws Exception {
        User user = null;
        int id = result.getInt("id");
        String name = result.getString("name");
        String lastName1 = result.getString("lastName1");
        String lastName2 = result.getString("lastName2");
        String userName = result.getString("userName");
        String email = result.getString("email");
        String pass = result.getString("pass");
        LocalDate born = result.getDate("born").toLocalDate();
        String gender = result.getString("gender");
        String userType = result.getString("userType");
        String phone = result.getString("phone");
        int gen = 0;
        if (gender == "Masculino"){
            gen = 1;
        }
        else if (gender == "Femenino"){
            gen = 2;
        }
        else if(gender == "Otro"){
            gen = 3;
        }

        if(userType.equals("Cliente")){
            user = new Client(id, name, lastName1, lastName2, userName, email, pass, born, gen, phone);

            List<Direction> directions = new ArrayList<>();
            Direction direction = null;
            String queryStringUser = "SELECT * FROM Direction " +
                    "WHERE idUser = " + user.getId();
            ResultSet resultDirection = dataAccess.selectData(queryStringUser);
            try{
                while (resultDirection.next())
                {
                    ((Client)user).setDirections(resultDirection.getString("exactAddress"),
                            resultDirection.getString("district"),
                            resultDirection.getString("canton"),
                            resultDirection.getString("province"),
                            resultDirection.getInt("kilometersToRestaurant"));
                }
            }
            catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }
        else if(userType.equals("Administrador")) {
            user = new Admin(id, name, lastName1, lastName2, userName, email, pass, born, gen, phone);
        }
        else if(userType.equals("Empleado")){
            user = new Employee(id, name, lastName1, lastName2, userName, email, pass, born, gen, phone);
        }
        return user;
    }
}
