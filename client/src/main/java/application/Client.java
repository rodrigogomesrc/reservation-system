package application;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello world from Client");

        //Testing converting Object to String
        /*
        ClientData object = new ClientData(123, "teste");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = ow.writeValueAsString(object);
            System.out.println(json);
        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
         */

        /*
        RestaurantListInterface restaurants = (RestaurantListInterface) Naming.lookup("rmi://127.0.0.1:1098/RestaurantServer");

        System.out.println("*** Sistema de reservas de Restaurante ***");
        System.out.println("Para utilizar o sistema, vamos fazer o seu cadastro. ");
        Scanner sc;
        sc = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        String name = sc.nextLine();

        System.out.println("Digite o seu cpf: ");
        long cpf = sc.nextLong();

        while(true){
            System.out.println("");
            System.out.println("Digite uma das opções: ");
            System.out.println("1 para ver o menu");
            System.out.println("2 para fazer uma reserva");
            System.out.println("3 para cancelar uma reserva");
            System.out.println("Digite outro número para sair do programa");

            sc = new Scanner(System.in);
            int option = sc.nextInt();

            if(option == 1){

                String restaurantName = getRestaurantName(restaurants);

                System.out.println("Digite o nome do Restaurante: ");
                sc = new Scanner(System.in);

                System.out.println("*** Menu ***");
                System.out.println(restaurants.getRestaurantMenu(restaurantName));

            } else if (option == 2){

                String restaurantName = getRestaurantName(restaurants);
                System.out.println("Digite a data da reserva: ");
                sc = new Scanner(System.in);
                String date = sc.nextLine();

                ClientDataDTO client = new ClientDataDTO(cpf, name);
                ClientCommunicationInterface clientCommunication = new ClientCommunication();
                System.out.println(restaurants.attemptReservation(restaurantName, date, client, clientCommunication));

            } else if (option == 3) {
                String restaurantName = getRestaurantName(restaurants);
                System.out.println("Digite a data da reserva: ");
                sc = new Scanner(System.in);
                String date = sc.nextLine();
                System.out.println(restaurants.cancelReservation(restaurantName, date, cpf));
            } else {
                break;
            }
        }
        */

    }

    /*
    private static String getRestaurantName(RestaurantListInterface restaurants){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> restaurantsList = restaurants.getRestaurantList();
        HashMap<Integer,String> restaurantsIndice = new HashMap<>();

        int indice = 1;
        for(String r: restaurantsList){
            System.out.println(indice + " - " + r);
            restaurantsIndice.put(indice, r);
            indice++;
        }

        String restaurantName = "";

        while(true){
            System.out.println("Digite o código do Restaurante: ");
            sc = new Scanner(System.in);
            int restaurantCode = sc.nextInt();

            if(restaurantsIndice.containsKey(restaurantCode)){
                return restaurantsIndice.get(restaurantCode);
            } else {
                System.out.println("Código Inválido. Digite novamente: ");
            }

        }
    }

     */
}
