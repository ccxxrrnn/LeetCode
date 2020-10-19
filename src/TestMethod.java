import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-15 17:05
 **/
public class TestMethod {
    public void callableTest1() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable 已经运行啦");
                return "this is Callable is running";
            }
        };

        FutureTask<String> futureTask = new FutureTask<String>(callable);
        futureTask.run();

        try {
            if (futureTask.isDone()){   //任务完成
                System.out.println(futureTask.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public int[] LRU (int[][] operators, int k) {
        // write code here
        HashMap<Integer,Integer> lRu=new LinkedHashMap<>();
        List<Integer> resultList=new ArrayList<>();
        for(int[] operator:operators){
            if(operator[0]==1){
                if(lRu.size()<k){
                    lRu.put(operator[1],operator[2]);
                }
                else
                {
                    Iterator ite=lRu.keySet().iterator();
                    int key=(int)ite.next();
                    System.out.println(key);
                    int value=lRu.get(key);
                    lRu.remove(key,value);
                    lRu.put(operator[1],operator[2]);
                }
            }
            if(operator[0]==2){
                if(lRu.containsKey(operator[1])){
                    int value=lRu.get(operator[1]);
                    resultList.add(value);
                    lRu.remove(operator[1]);
                    lRu.put(operator[1],value);

                }else{
                    resultList.add(-1);
                }
            }
        }
        int[] result=new int[resultList.size()];
        int j=0;
        for(int rs:resultList){
            result[j++]=rs;
        }
        return result;
    }
}
