package io.github.maxmilite.expbottle.utils;

import io.github.maxmilite.expbottle.bottle.BottleMethod;
import org.bukkit.entity.Player;

public class Utils {

    public final int maxExp = 1000;
    public BottleMethod bottleMethod = new BottleMethod();

    public int getExp(int x) {
        if (x <= 0)
            return 0;
        else if (x <= 16)
            return x * x + 6 * x;
        else if (x <= 31)
            return (int) (2.5 * x * x - 40.5 * x + 360);
        else
            return (int) (4.5 * x * x - 162.5 * x + 2220);
    }

    public boolean ifValid(Player player, int type, int value, int bottleValue) {
        int existsExp = getExp(player.getLevel()) + (int) (player.getExp() * player.getExpToLevel());
        int realExp;
        switch (type) {
            case 1:
                realExp = getExp(value);
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                return realExp <= existsExp;
            case 2:
                realExp = existsExp - getExp(value);
                if (value > player.getLevel())
                    return false;
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                return realExp <= existsExp;
            case 3:
                realExp = value;
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                return realExp <= existsExp;
            case 4:
                realExp = existsExp;
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                return realExp <= existsExp;
            case 5:
                realExp = getExp(value);
                if (bottleValue < realExp)
                    realExp = bottleValue;
                return true;
            case 6:
                realExp = getExp(value) - existsExp;
                if (value <= player.getLevel())
                    return false;
                if (bottleValue < realExp)
                    realExp = bottleValue;
                return true;
            case 7:
                realExp = value;
                if (bottleValue < realExp)
                    realExp = bottleValue;
                return true;
            case 8:
                realExp = bottleValue;
                return true;
        }
        return false;
    }

    public void HandleOperation(Player player, int type, int value, int bottleValue) {
        int existsExp = getExp(player.getLevel()) + (int) (player.getExp() * player.getExpToLevel());
        int realExp;
        switch (type) {
            case 1:
                realExp = getExp(value);
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                player.giveExp(-realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue + realExp);
                break;
            case 2:
                realExp = existsExp - getExp(value);
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                player.giveExp(-realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue + realExp);
                break;
            case 3:
                realExp = value;
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                player.giveExp(-realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue + realExp);
                break;
            case 4:
                realExp = existsExp;
                if (maxExp - bottleValue < realExp)
                    realExp = maxExp - bottleValue;
                player.giveExp(-realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue + realExp);
                break;
            case 5:
                realExp = getExp(value);
                if (bottleValue < realExp)
                    realExp = bottleValue;
                player.giveExp(realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue - realExp);
                break;
            case 6:
                realExp = getExp(value) - existsExp;
                if (bottleValue < realExp)
                    realExp = bottleValue;
                player.giveExp(realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue - realExp);
                break;
            case 7:
                realExp = value;
                if (bottleValue < realExp)
                    realExp = bottleValue;
                player.giveExp(realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue - realExp);
                break;
            case 8:
                realExp = bottleValue;
                player.giveExp(realExp);
                bottleMethod.setExpValue(player.getInventory().getItemInMainHand(), bottleValue - realExp);
                break;
        }
    }
}
