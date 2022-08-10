import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

			private List<T> queue = new LinkedList<T>();
		    private int limit = 10;
		    

		    
		    public int getLimit() {
				return limit;
			}



			public synchronized boolean put(T item) {
				if( queue.size()<=limit) {
					queue.add(item);
					return true;
				}
				else
					return false;
		        
		    }

		    public synchronized  T take() throws InterruptedException {
		        return queue.remove(0);
		    }
		    
		     
			
		
}
