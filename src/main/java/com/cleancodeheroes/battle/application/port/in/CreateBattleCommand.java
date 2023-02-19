package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.kernel.command.Command;

import java.util.Objects;

public class CreateBattleCommand implements Command {
    private final Battle battle;

    public CreateBattleCommand (Battle battle) { this.battle = battle; }

    public Battle getBattle () { return battle ; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateBattleCommand that = (CreateBattleCommand) o;
        return Objects.equals(battle, that.battle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(battle);
    }
}
