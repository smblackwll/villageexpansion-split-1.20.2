package ninjadude75.villageexpansion.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class NobleBossEntity extends PathAwareEntity {
    private final ServerBossBar bossBar;

    public NobleBossEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(Text.translatable("entity.villageexpansion.noble_boss"), BossBar.Color.RED, BossBar.Style.PROGRESS);
    }

    public static DefaultAttributeContainer.Builder createBossAttributes(){
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 75)
                .add(EntityAttributes.GENERIC_ARMOR, 5);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossBar.setPercent(this.getHealth()/this.getMaxHealth());
    }
}
