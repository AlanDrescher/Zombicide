package zombicide;

public class Humanoide {
	// Variables
	private String name;
	private int health;
	private int maxHealth;
	private boolean status;

	// Constructor
	protected Humanoide(String name, int health, int maxHealth, boolean status) {
		setName(name);
		setHealth(health);
		setMaxHealth(maxHealth);
		setStatus(status);
	}

	// SETTERS Y GETTERS
	// Nombre
	protected String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	// Salud
	protected int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}

	// Salud Máxima
	protected int getMaxHealth() {
		return maxHealth;
	}

	void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	// Vivo o Muerto
	protected boolean getStatus() {
		return status;
	}

	protected void setStatus(boolean status) {
		this.status = status;
	}
}
