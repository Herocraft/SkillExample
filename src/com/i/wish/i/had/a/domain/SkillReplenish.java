package com.i.wish.i.had.a.domain;

import com.herocraftonline.dev.heroes.Heroes;
import com.herocraftonline.dev.heroes.persistence.Hero;
import com.herocraftonline.dev.heroes.skill.ActiveSkill;
import com.herocraftonline.dev.heroes.util.Messaging;
import java.util.List;

public class SkillReplenish extends ActiveSkill
{
  public SkillReplenish(Heroes plugin)
  {
    super(plugin);
    setName("Replenish");
    setDescription("Brings your mana back to full");
    setUsage("/skill replenish");
    setMinArgs(0);
    setMaxArgs(0);
    getIdentifiers().add("skill replenish");
  }

  public boolean use(Hero hero, String[] args)
  {
    hero.setMana(100);
    Messaging.send(hero.getPlayer(), "Your mana has been fully replenished!", new Object[0]);
    if (hero.isVerbose()) {
      Messaging.send(hero.getPlayer(), Messaging.createManaBar(100), new Object[0]);
    }
    broadcastExecuteText(hero);
    return true;
  }
}