package relics;

import basemod.abstracts.CustomRelic;
import basemod.helpers.CardModifierManager;
import cardmods.CardModEthereal;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import util.TextureLoader;

public class RelicIridiumChain extends CustomRelic {
    public static final String ID = "reliquary:IridiumChain";
    private static final Texture IMG = TextureLoader.getTexture("reliquaryAssets/images/iridiumChain.png");
    private static final Texture OUTLINE  = TextureLoader.getTexture("reliquaryAssets/images/outlines/iridiumChain.png");

    public RelicIridiumChain() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.CLINK);
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.type != AbstractCard.CardType.POWER)
            return;
        AbstractCard copy = c.makeStatEquivalentCopy();
        c.modifyCostForCombat(1);
        if (!c.isEthereal) {
            CardModifierManager.addModifier(c, new CardModEthereal());
        }
        c.initializeDescription();
        addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        addToBot(new MakeTempCardInHandAction(c));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
    @Override
    public AbstractRelic makeCopy()
    {
        return new RelicIridiumChain();
    }
}