package models;

public class Store {

    private Item[][] items;

    public Store() {
        this.items = new Item[7][3];
    }
    public Item getItems(int row, int column) {
        return new Item(items[row][column]);
    }
    public void setItems(int row, int column, Item item) {
        this.items[row][column] = new Item(item);
    }

    public String toString() {
        String temp = " ";
        for (int i = 0; i < items.length; i++) {
            switch (i) {
                case 0 -> temp += "\tDRINKS:        ";
                case 1 -> temp += "\tCEREAL:        ";
                case 2 -> temp += "\tDAIRY:         ";
                case 3 -> temp += "\tDELI:          ";
                case 4 -> temp += "\tGREENS:        ";
                case 5 -> temp += "\tCLOTHING:      ";
                case 6 -> temp += "\tELECTRONICS:   ";
            }
            for (int j = 0; j < items[i].length; j++) {
                temp += this.items[i][j].toString();
            }
            temp += "\n\n";
        }
        temp +="\t************************************************************************\n";
        return temp;
    }

}
