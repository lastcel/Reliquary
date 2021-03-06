package actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ApplyPowerIfAbsentAction extends AbstractGameAction {
    AbstractCreature target, source;
    AbstractPower power;

    public ApplyPowerIfAbsentAction(AbstractCreature target, AbstractCreature source, AbstractPower power) {
        this.target = target;
        this.source = source;
        this.power = power;
        actionType = ActionType.POWER;
    }

    @Override
    public void update() {
        if (!target.hasPower(power.ID)) {
            addToTop(new ApplyPowerAction(target, source, power));
        }
        isDone = true;
    }
}
