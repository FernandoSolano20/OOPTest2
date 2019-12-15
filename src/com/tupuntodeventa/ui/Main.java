package com.tupuntodeventa.ui;

import com.tupuntodeventa.tl.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner read = new Scanner(System.in);
    private static Controller controller = new Controller();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opc = 0;
        try {
            if(!controller.isAdminOnDB()){
                System.out.println(registerUser(0));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        do{
            System.out.println("Digite lo que desea hacer");
            System.out.println("1- Iniciar Sesión");
            System.out.println("2- Registro de clientes");
            System.out.println("3- Salir");
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 3);
    }

    private static void menuAdmin() throws Exception {
        int opc = 0;
        do {
            System.out.println("Digite lo que desea hacer");
            System.out.println("1- Registro de puestos");
            System.out.println("2- Listado de puestos");
            System.out.println("3- Registro de empleados");
            System.out.println("4- Registro de cupones");
            System.out.println("5- Registro de productos");
            System.out.println("6- Listado de usuarios");
            System.out.println("7- Listado de cupones");
            System.out.println("8- Lista de productos");
            System.out.println("9- Lista de órdenes");
            System.out.println("10- Salir");
            opc = read.nextInt();
            procesarOpcionAdmin(opc);
        }while (opc != 10);
    }

    private static void menuClient() throws Exception {
        int opc = 0;
        do {
            System.out.println("Digite lo que desea hacer");
            System.out.println("1- Registro órdenes");
            System.out.println("2- Salir");
            opc = read.nextInt();
            procesarOpcionClient(opc);
        }while (opc != 2);
    }

    private static void login() throws Exception {
        System.out.println("Digite el nombre de usuario");
        String userName = read.next();

        System.out.println("Digite la contraseña");
        String pass = read.next();
        if(controller.login(userName,pass).equals("Administrador")){
            menuAdmin();
        }
        else if(controller.login(userName,pass).equals("Cliente")){
            menuClient();
        }
    }

    private static void procesarOpcion(int opc){
        String msg = "";
        try {
            switch (opc){
                case 1:
                    login();
                    break;

                case 2:
                    System.out.println(registerUser(opc));
                    break;

                case 3:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("No valida");
                    break;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void procesarOpcionAdmin(int opc) throws Exception {
        switch (opc) {
            case 1:
                System.out.println(registerPosition());
                break;

            case 2:
                printArray(controller.listPositions());
                break;

            case 3:
                System.out.println(registerUser(opc));
                break;

            case 4:
                System.out.println(registerCoupon());
                break;

            case 5:
                System.out.println(registerProduct());
                break;

            case 6:
                printArray(controller.listUsers());
                break;

            case 7:
                printArray(controller.listCoupons());
                break;

            case 8:
                printArray(controller.listProducts());
                break;

            case 9:
                printArray(controller.listOrdens());
                break;

            case 10:
                System.out.println("Salir");
                break;

            default:
                System.out.println("No valida");
                break;
        }
    }

    private static void procesarOpcionClient(int opc) throws Exception {
        switch (opc) {
            case 1:
                System.out.println(registerOrden());
                break;

            case 2:
                System.out.println("Salir");
                break;

            default:
                System.out.println("No valida");
                break;
        }
    }

    private static String registerOrden() throws Exception {
        ArrayList<Integer> codes = new ArrayList<>();
        int opc = 0;
        do{
            System.out.println("Digite el codigo del producto");
            int code = read.nextInt();
            codes.add(code);

            System.out.println("Digitar otra producto");
            System.out.println("1- Si");
            System.out.println("2- No");
            opc = read.nextInt();
        }while (opc == 1);
        return controller.registerOrden("Orden Cliente",codes);
    }

    private static String registerPosition() throws Exception {
        System.out.println("Digite el nombre");
        String name = read.next();

        System.out.println("Digite el salario base");
        int baseSalary = read.nextInt();

        System.out.println("Digite el bonus");
        int bonus = read.nextInt();

        int totalSalary = baseSalary + bonus;

        System.out.println("Digite el dia de contrato");
        int day = read.nextInt();

        System.out.println("Digite el mes de contrato");
        int month = read.nextInt();

        System.out.println("Digite el año de contrato");
        int year = read.nextInt();

        return controller.registerPosition(name,baseSalary,bonus,totalSalary,LocalDate.of(year,month,day));
    }

    private static String registerUser(int opc) throws Exception {
        System.out.println("Digite su identificacion");
        int id = read.nextInt();

        System.out.println("Digite el nombre");
        String name = read.next();

        System.out.println("Digite el primer apellido");
        String lastName1 = read.next();

        System.out.println("Digite el segundo apellido");
        String lastName2 = read.next();

        System.out.println("Digite el nombre de usuario");
        String userName = read.next();

        System.out.println("Digite el email");
        String email = read.next();

        System.out.println("Digite la contraseña");
        String pass = read.next();

        System.out.println("Digite el dia de nacimiento");
        int day = read.nextInt();

        System.out.println("Digite el mes de nacimiento");
        int month = read.nextInt();

        System.out.println("Digite el año de nacimiento");
        int year = read.nextInt();

        int gender = 0;
        do{
            System.out.println("Digite el genero");
            System.out.println("1- Masculino");
            System.out.println("2- Femenino");
            System.out.println("3- Otro");
            gender = read.nextInt();
        }while (gender != 1 && gender != 2 && gender != 3);

        System.out.println("Digite el telefono");
        String phone = read.next();

        if(opc == 0){
            return controller.registerAdmin(id,name,lastName1,lastName2,userName,email,pass,day,month,year,gender,phone);
        }
        else if(opc == 2) {
            return registerClient(id,name,lastName1,lastName2,userName,email,pass,day,month,year,gender,phone);
        }
        else {
            return registerEmployee(id,name,lastName1,lastName2,userName,email,pass,day,month,year,gender,phone);
        }
    }

    private static String registerEmployee(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone) throws Exception {
        System.out.println("Digite el puesto");
        String puesto = read.next();
        return controller.registerEmployee(id,name,lastName1,lastName2,userName,email,pass,day,month,year,gender,phone,puesto);
    }

    private static String registerClient(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone) throws Exception {
        int opc = 0;
        ArrayList<String[]> directions = new ArrayList<>();
        String msg = "";
        do{
            String[] direction = new String[5];
            System.out.println("Digite la direccion exacta");
            direction[0] = read.next();

            System.out.println("Digite el distrito");
            direction[1] = read.next();

            System.out.println("Digite el canton");
            direction[2] = read.next();

            System.out.println("Digite el provincia");
            direction[3]= read.next();

            System.out.println("Digite los kilómetros que separan al cliente del restaurante");
            direction[4] = read.next();

            directions.add(direction);

            System.out.println("Digitar otra direccion");
            System.out.println("1- Si");
            System.out.println("2- No");
            opc = read.nextInt();
        }while (opc == 1);
        msg = controller.registerClient(id,name,lastName1,lastName2,userName,email,pass,day,month,year,gender,phone,directions);
        return msg;
    }

    private static String registerCoupon(){
        System.out.println("Digite el dia de vencimiento");
        int day = read.nextInt();

        System.out.println("Digite el mes de vencimiento");
        int month = read.nextInt();

        System.out.println("Digite el año de vencimiento");
        int year = read.nextInt();

        int sta = 0;
        do{
            System.out.println("Digite el estado, si esta redimido");
            System.out.println("1- Si");
            System.out.println("2- No");
            sta = read.nextInt();
        }while (sta != 1 && sta != 2);
        boolean status = sta == 1;

        System.out.println("Digite el descuento");
        int discount = read.nextInt();

        return controller.registerCoupon(day,month,year,status,discount);
    }

    private static String registerProduct() throws Exception {
        System.out.println("Digite lo que desea hacer");
        System.out.println("1- Registro de plato");
        System.out.println("2- Registro de combo");
        int opc = read.nextInt();
        return procesarOpcionProducto(opc);
    }

    private static String procesarOpcionProducto(int opc) throws Exception {
        switch (opc){
            case 1:
                return registerPlate();

            case 2:
                return registerCombo();

            default:
                return "No valido";
        }
    }

    private static String registerPlate() throws Exception {
        System.out.println("Digite el codigo");
        int code = read.nextInt();

        System.out.println("Digite el precio");
        int price = read.nextInt();

        System.out.println("Digite la descripcion");
        String descript = read.next();

        return controller.registerPlate(code,price,descript);
    }

    private static String registerCombo() throws Exception {
        System.out.println("Digite el codigo");
        int code = read.nextInt();

        System.out.println("Digite la name");
        String name = read.next();

        System.out.println("Digite el precio");
        int price= read.nextInt();

        String msg = controller.registerCombo(code,name,price);
        int opc = 0;
        do{
            int plate = 0;
            do{
                System.out.println("Digite si quiere agregar un nuevo plato o un plato ya existente");
                System.out.println("1- Nuevo plato");
                System.out.println("2- Plato existente");
                plate = read.nextInt();
            }while (plate != 1 && plate != 2);

            if(plate == 1){
                System.out.println(registerPlateCombo(code));
            }
            else {
                System.out.println(searchPlate(code));
            }
            System.out.println("Digitar otra plato");
            System.out.println("1- Si");
            System.out.println("2- No");
            opc = read.nextInt();
        }while (opc == 1);
        return msg;
    }

    private static String registerPlateCombo(int codeCombo) throws Exception {
        System.out.println("Digite el codigo");
        int code = read.nextInt();

        System.out.println("Digite el precio");
        int price = read.nextInt();

        System.out.println("Digite la descripcion");
        String descript = read.next();

        return controller.registerPlateCombo(codeCombo,code,price,descript);
    }

    private static String searchPlate(int codeCombo) throws Exception {
        System.out.println("Digite codigo del plato");
        int code = read.nextInt();
        return controller.searchPlate(codeCombo,code);
    }

    private static void printArray(List<String> array){
        for (String item:array) {
            System.out.println(item);
        }
    }
}
