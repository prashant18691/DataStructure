package com.test.prs.designpattern.cor;

 class Creature {
    private String name;
    private int attack;
    private int defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}

class CreatureModifier{
    protected Creature creature;
    private CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void add(CreatureModifier cm){
        if (next!=null)
            next.add(cm);
        else
            next = cm;
    }

    public void handle(){
        if (next!=null) next.handle();
    }
}

class DoubleAttackModifier extends CreatureModifier{
    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Doubling attack");
        creature.setAttack(creature.getAttack()*2);
        super.handle();
    }
}

class IncreaseDefenseModifier extends CreatureModifier{
    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Increasing defense by 2");
        creature.setDefense(creature.getDefense()+2);
        super.handle();
    }
}

public class TestCreature{

    public static void main(String[] args) {
        Creature creature = new Creature("Harambe",2,3);
        System.out.println(creature);
        CreatureModifier root = new CreatureModifier(creature);

        root.add(new DoubleAttackModifier(creature));
        root.add(new IncreaseDefenseModifier(creature));

        root.handle();

        System.out.println(creature);
    }

}
