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

    public void deleteFirst(){
      Node tmp = first;
      first = first.prev;
      first.next=null;
      tmp=null;
    }

    public void deleteLast(){
      Node tmp = last;
      last = last.next;
      last.prev=null;
      tmp=null;
    }

    public void deleteAtIndex(Node n, int index){
      Node tmp=last;
      int cont=0;

      while(cont<index){
        tmp=tmp.next;
        cont++;
      }
    }

    public void printListRev(){
      Node tmp=first;

      while(tmp!=null)
      {
        System.out.println(tmp.name);
        tmp=tmp.prev;
      }
    }


}
