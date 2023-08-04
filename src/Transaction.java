public class Transaction {
    String name;
    int quantity;
    int unitPrice;
    boolean isExpense;
    Transaction(String line){
        String[] lineContents = line.split(",");
        this.name = lineContents[0];
        this.isExpense = lineContents[1].equals("true");
        this.quantity = Integer.parseInt(lineContents[2]);
        this.unitPrice = Integer.parseInt(lineContents[3]);

    }



}
