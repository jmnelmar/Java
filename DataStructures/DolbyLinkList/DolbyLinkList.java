public class DolbyLinkList{
    Node first;
    Node last;

    public DolbyLinkList(){
        first = null;
        last = null;
    }

    public void addAtFirst(Node n)
    {
        if(first==null)
            first = n;
        else
            last.prev = n;
        n.next=last;
        last=n;
    }

    public void addAtLast(Node n){
        if(first==null)
            last=n;
        else{
            first.next=n;
            n.prev= first;
        }

        first = n;
    }

    public void printList(){
        Node tmp=last;

        while(tmp!=null){
            System.out.println(tmp.name);
            tmp=tmp.next;
        }
    }

    public void addAtIndex(int index, Node n){
        int cont=0;
        Node tmp=last;

        while(cont<index){
            cont+=1;
            tmp=tmp.next;
        }

        if(tmp==first){
            first.next=n;
        }else{
            n.prev = tmp;
            tmp.next.prev=n;
        }
        n.next = tmp.next;
        tmp.next=n;


    }

    public void deleteAtfirst(){
        //Not finished yet
        last = last.next;
        last.prev=null;
        
    }
}