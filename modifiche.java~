//Modifiche da apportare al progetto
//per fare a meno dell'istanza di Cliente
//utilizzata come appoggio


//In SPMotorbet.java

public class SPMotorBet {
    private static SPMotorBet Singleton;   //GoF Singleton Pattern
    
    DAOCliente DaoCliente
    Cliente cliente;
    private List<Cliente> clienti;
    Conto conto;
    Movimento movimento;
    boolean clienteEsistente = false;
    float saldo;
    int count = 0;
    
    private SPMotorBet(){
        this.clienti = new ArrayList<Cliente>();
	this.DaoCliente = new DAOCliente();
	this.clienti = this.DaoCLienti.caricaLista();
    };
    
    public static SPMotorBet getInstance(){ //GoF Singleton Pattern
        if(Singleton == null){
            Singleton = new SPMotorBet();
        }
        return Singleton;
    }

//in modo simile per gli altri DAO

//nella classe Cliente

    public boolean salva(DateFormat format2, DAOCliente DC){
    	return(DC.salva(this, format2));
    }
	
