public class StarsPrinter {
    private int size;
    public StarsPrinter(int size){
       this.size=size;
    }
    public void printBottom () {
        for (int i = 1; i <= size; i++) {
            printString (i," ");
            printString (size-i,"* ");
            System.out.println ();
        }
    }

    public void printTop () {
        for (int i = 1; i <= size; i++) {
            printString (size - i," ");
            printString (i,"* ");
            System.out.println ();
        }
    }
   private void printString (int count,String string) {
        for (int i = 0; i < count; i++) {
            System.out.print (string);
        }
    }
    public void printEntireRhombus(){
        printTop ();
        printBottom ();
    }
}
