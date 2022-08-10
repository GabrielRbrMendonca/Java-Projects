public enum Especialidade {
	ORTOPEDIA(200.00),OTORRINO(180),ALERGOLOGIA(160),URULOGIA(300),NEUROLOGIA(400);
	private double val;
	
	Especialidade(double val){
		this.val=val;
	}
	
    
	public double preco() {
		return this.val;
	}
	
	
 }
	
    	
    
    
 
    
    

