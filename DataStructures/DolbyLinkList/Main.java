public class Main{
    public static void main(String[] args){
        Node n= new Node();
        DolbyLinkList dl= new DolbyLinkList();
        n.id=1;
        n.name="Nelson";
        dl.addAtFirst(n);
        n= new Node();
        n.id=2;
        n.name="Veronica";
        dl.addAtFirst(n);
        System.out.println("\nPrinting inserting at first");
        dl.printList();
        n= new Node();
        n.id=3;
        n.name="Keiry";
        dl.addAtLast(n);
        n= new Node();
        n.id=4;
        n.name="Marta";
        dl.addAtLast(n);
        System.out.println("\nPrinting inserting at last");
        dl.printList();
        System.out.println("\nCleaning the list and Inserting at last");
        dl=new DolbyLinkList();
        n= new Node();
        n.id=1;
        n.name="Keiry";
        dl.addAtLast(n);
        n= new Node();
        n.id=2;
        n.name="Marta";
        dl.addAtLast(n);
        n= new Node();
        n.id=3;
        n.name="Erika";
        dl.addAtLast(n);
        n= new Node();
        n.id=4;
        n.name="Nelsito";
        dl.addAtLast(n);
        dl.printList();

        System.out.println("\nAdding at index");
        n= new Node();
        n.id=5;
        n.name="Rutilia";
        dl.addAtIndex(2,n);
        dl.printList();
        
        

    }
}