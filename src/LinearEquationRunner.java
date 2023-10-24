import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter coordinate 1: ");
        String coor1 = scan.nextLine();
        System.out.println("Enter coordinate 2: ");
        String coor2 = scan.nextLine();
        String point1F = coor1.substring(1, coor1.length() - 1);
        String point2F = coor2.substring(1, coor2.length() - 1);
        point1F = point1F.replace(" ", "");
        point2F = point2F.replace(" ", "");
        int x1 = Integer.parseInt(point1F.split(",")[0]);
        int y1 = Integer.parseInt(point1F.split(",")[1]);
        int x2 = Integer.parseInt(point2F.split(",")[0]);
        int y2 = Integer.parseInt(point2F.split(",")[1]);
        LinearEquation line = new LinearEquation(x1, y1, x2, y2);
        System.out.println(line.lineInfo());

        System.out.println("Enter a value for x: ");
        double xValue = scan.nextDouble();
        scan.close();
        System.out.printf("\nCoordinate for x: %s", line.coordinateForX(xValue));
    }
}
