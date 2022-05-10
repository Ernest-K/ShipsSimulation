package pl.pwr.shipsSimulation.battle;

import pl.pwr.shipsSimulation.terrain.Terrain;

public class BattleResolver {
    private final Terrain terrain;

    public BattleResolver(Terrain terrain) {
        this.terrain = terrain;
    }

    public BattleResult resolve(Battle battle){
        BattleResult battleResult = new BattleResult();
        if (battle.getAttacker().getShip().getShipStatistic().getAttack() > battle.getDefender().getShip().getShipStatistic().getAttack()){
            battleResult.setLoserShip(battle.getDefender());
            battleResult.setWinnerShip(battle.getAttacker());
        }else{
            battleResult.setLoserShip(battle.getAttacker());
            battleResult.setWinnerShip(battle.getDefender());
        }
        return battleResult;
    }
}
