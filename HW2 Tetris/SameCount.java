package New;
import java.util.*;
import java.util.Collection;

public class SameCount {

      public static <T> int sameCount(Collection<T> a,Collection<T> b){
            HashMap<T,Integer> map_a =new HashMap<T,Integer>();
            HashMap<T,Integer> map_b=new HashMap<T,Integer>();
            HashSet<T> list=new HashSet<T>();
            for(T key:a){
                  map_a.put(key,map_a.getOrDefault(key,0)+1);
                  list.add(key);
            }
            for(T key:b){
                  map_b.put(key,map_b.getOrDefault(key,0)+1);
            }
            int count=0;
            for (T key:list) {
                  int countA = map_a.get(key);
                  int countB = map_b.getOrDefault(key, 0);
                  if (countA == countB) {
                        count++;
                  }
            }
      return count;
      }
      public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int sizeofA=sc.nextInt();
            int sizeofB=sc.nextInt();
            Collection<String>a=new ArrayList<String>();
            Collection<String>b=new ArrayList<String>();
            for(int i=1;i<=sizeofA;i++){
                  a.add(sc.next());
            }
            for(int i=1;i<=sizeofB;i++){
                  b.add(sc.next());
            }
            System.out.print(SameCount.sameCount(a,b));
      }
}
