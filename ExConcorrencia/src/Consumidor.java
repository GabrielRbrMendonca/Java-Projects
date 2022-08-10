public class Consumidor<T> implements Runnable {
	
	private BlockingQueue<T> fila;

	public Consumidor(BlockingQueue<T> queue) {
		this.fila = queue;
	}

	
	@Override
	public void run() {
				T item;
				while (true) {
					try {
						item = fila.take();
						if (item != null) {
							System.out.println("Removido da fila: "+ item);
						} else {
							System.out.println("Item não encontrado");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
		
		
	}
}

