package sr.ice.server;

import Demo.FreqIdemp;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Util;

public class FreqIdempI implements FreqIdemp {
	private final long id;

	public FreqIdempI(long id) {
		System.out.printf("[FreqIdemp] Servant with id: %x created\n",id);
		this.id = id;
	}

	@Override
	public int add(int a, int b, Current current) {
		System.out.println("ADD: a = " + a + ", b = " + b + ", result = " + (a + b));

		if (a > 1000 || b > 1000) {
			try {
				Thread.sleep(6000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		if (current.ctx.values().size() > 0) {
			System.out.println("There are some properties in the context\n");
		}
		System.out.printf("[FreqIdemp] Servant id: %x, Object id: %s " +
						"- adding two factors\n"
				,this.id, Util.identityToString(current.id));
		return a + b;
	}
}