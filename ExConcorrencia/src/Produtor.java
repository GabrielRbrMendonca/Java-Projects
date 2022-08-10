public class Produtor<T> implements Runnable{
	
	private BlockingQueue<T> fila;	
	
	public Produtor(BlockingQueue<T> queue) {
		this.fila = queue;
	}



	@Override
	public void run() {
		
		while (true) {
			if (fila.put(null)) {
				System.out.println("Item adicionado.");
			}

		}

	}
}
