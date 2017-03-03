import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

class Task3{
    String allItems;
    double allItemsPrice;
    DecimalFormat twodp;
    public Task3(){
        allItems = "";
        allItemsPrice = 0;
        twodp = new DecimalFormat("#.00");
        Scanner menuIn = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = menuIn.nextInt();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    printReceipt();
                    break;
                case 3:
                    printAndExit();
                    break;
                default:
                    System.err.println("ERROR! INVALID CHOICE");
            }
        } while (choice != 3);
    }
    public void displayMenu(){
        System.out.println("1. Add Item");
        System.out.println("2. Print Receipt");
        System.out.println("3. Print Receipt and Exit");
    }
    public void addItem() {
        Scanner userIn = new Scanner(System.in);
        System.out.print("Enter Item GTIN-8 Code: ");
        String itemNum = userIn.nextLine();
        System.out.print("Enter Number of Items: ");
        int numItems = Integer.parseInt(userIn.nextLine());
        double currentPrice = getPrice(itemNum);
        allItemsPrice += currentPrice * numItems;
        if (allItems.length() > 0) {
            allItems += ":";
        }
        allItems += itemNum;
        allItems += " ";
        allItems += getName(itemNum);
        allItems += " ";
        allItems += Integer.toString(numItems);
        allItems += " ";
        allItems += twodp.format(currentPrice);
        allItems += " £";
        allItems += twodp.format(currentPrice * numItems);
    }
    public double getPrice(String param){
        String current = "";
        String[] currentLine;
        Scanner fileIn = null;
        double r = 0.0;
        try {
            fileIn = new Scanner(new File("itemlist.txt"));
        }catch(Exception e){}
        while(fileIn.hasNext()){
            current = fileIn.nextLine();
            currentLine = current.split(",");
            if(currentLine[0].equals(param)){
                r = Double.parseDouble(currentLine[2]);
            }
        }
        return r;
    }
    public String getName(String param){
        String current = "";
        String[] currentLine;
        Scanner fileIn = null;
        String r = "Product Not Found";
        try {
            fileIn = new Scanner(new File("itemList.txt"));
        }catch(Exception e){}
        while(fileIn.hasNext()){
            current = fileIn.nextLine();
            currentLine = current.split(",");
            if(currentLine[0].equals(param)){
                r = currentLine[1];
            }
        }
        return r;
    }
    public void printReceipt(){
        if(allItems.length() == 0){
            System.err.println("NO ITEMS");
        }
        String[] items = allItems.split(":");
        int maxLength = 0;
        for(String current : items){
            maxLength = current.length() > maxLength ? current.length() : maxLength;
        }
        maxLength -= 1;
        for(String current : items){
            System.out.println(format(current, maxLength));
        }
        printTotal(maxLength - 1);
    }
    public String format(String orig, int length){
        String rest = orig.split("£")[0];
        String price = orig.split("£")[1];
        String working = "";
        String all = new String(rest).concat(working).concat(price);
        while(all.length() < length){
            working = working.concat(" ");
            all = new String(rest).concat(working).concat(price);
        }
        return all;
    }
    public void printTotal(int length){
        String total = new String("Total: ");
        String price = "£".concat(twodp.format(allItemsPrice));
        String working = "";
        String all = total.concat(working).concat(price);
        while(all.length() < length){
            working = working.concat(" ");
            all = new  String(total).concat(working).concat(price);
        }
        System.out.println(all);
    }
    public void printAndExit(){
        printReceipt();
        System.exit(0);
    }
    public static void main(String[] args){
        new Task3();
    }
    public class Props{
        public int getStock(String code){}
        public void setStock(String code, int num){
            Properties prop = new Properties();
            try{
                prop.load(new Scanner(new File("stocklist")));
            catch(Exception e){}
            prop.setProperty(code, Integer.toString(num));					
			prop.
        }
}
