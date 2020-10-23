package ui;
import model.*;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);


    public Menu(){

    }
    public void showMenu(){
        System.out.println("MENU: Elija una opcion segun su requerimiento");
        System.out.println("(1) Menu del usuario");
        System.out.println("(2) Menu del playlist");
        System.out.println("(3) Para mostrar los usarios registrados en la aplicacion");
        System.out.println("(4) Para mostrar los playlist registrados en la aplicacion");
        System.out.println("(5) Salir");
    }
    public int readOption(){
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    private void showMenuUser() {
		int option=0;
		System.out.println(
				"Menu Usuario\n" +
				"(1) Para crear un nuevo usuario\n" +
				"(2) Para crear una cancion e incluirla en el pool\n"+
				"(3) Para eliminar un álbum\n"+
				"(0) Para volver"
				);
		option= sc.nextInt();
		sc.nextLine();
		
		switch(option) {
        case 0:
            showMenu();
		case 1:
			readUser();
			break;
		case 2:
			editAlbum();
			break;
		case 3: 
			deleteAlbum();
			break;
		
		}
		
    }
    public String readUser(){
        System.out.println("Ingrese el apodo del usuario sin espacios");
        String userNickName = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario");
        String password = sc.nextLine();
        System.out.println("Ingrese la edad del usuario");
        int age = sc.nextInt();
        /*for(Team team: Team.values()){
            System.out.println(team);
        }*/
        return addUser(userNickName, password, age);
    }

    public String readSong(){
            System.out.println("Ingrese el titulo de la cancion");
            String userNickName = sc.nextLine();
            System.out.println("Ingrese el nombre del artista o banda cantautora");
            String password = sc.nextLine();
            System.out.println("Ingrese la fecha de lanzamiento");
            String age = sc.nextInt();
            /*for(Team team: Team.values()){
                System.out.println(team);
            }*/
            return users.addSong();
        }
    
}
