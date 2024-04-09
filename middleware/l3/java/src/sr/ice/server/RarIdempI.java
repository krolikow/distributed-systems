package sr.ice.server;

import Demo.RarIdemp;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RarIdempI implements RarIdemp {
    private final long id;
    private final List<Integer> data = new LinkedList<>();

    public RarIdempI(long id) {
        System.out.printf("[RarIdemp] Servant with id: %x created\n",id);
        this.id = id;
    }

    public void initializeArray(int n){
        Random random = new Random();
        for(int i =0;i<=n;i++){
            data.add(random.nextInt());
        }
    }

    @Override
    public int getData(int i, Current current) {
        initializeArray(2*i);
        System.out.printf("[RarIdemp] Servant id: %x, Object id: %s -" +
                " getting data of index %x \n",this.id, Util.identityToString(current.id),i);
        return data.get(i);
    }
}
