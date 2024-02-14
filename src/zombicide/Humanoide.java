package zombicide;

public class Humanoide {
	private String name;
	private int health;
	private int maxHealth;
	private boolean status;
	
	protected Humanoide() {
		setName(name);
		setHealth(health);
		setMaxHealth(maxHealth);
		setStatus(status);
	}
	
	//Nombre
	protected String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	//Salud
	protected int getHealth() {
		return health;
	}
	
	private void setHealth(int health) {
		this.health = health;
	}
	
	//Salud Máxima
	protected int getMaxHealth() {
		return maxHealth;
	}
	
	private void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	//Vivo o Muerto
	protected boolean getStatus() {
		return status;
	}
	
	private void setStatus(boolean status) {
		this.status = status;
	}
}
