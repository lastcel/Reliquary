package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.DamageAllButOneEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import util.TextureLoader;

public class RelicShortFuse extends CustomRelic {
    public static final String ID = "reliquary:ShortFuse";
    private static final Texture IMG = TextureLoader.getTexture("reliquaryAssets/images/shortFuse.png");
    private static final Texture OUTLINE  = TextureLoader.getTexture("reliquaryAssets/images/outlines/shortFuse.png");

    public RelicShortFuse() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.CLINK);
    }

    // implemented in PatchShortFuse

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
    @Override
    public AbstractRelic makeCopy()
    {
        return new RelicShortFuse();
    }
}