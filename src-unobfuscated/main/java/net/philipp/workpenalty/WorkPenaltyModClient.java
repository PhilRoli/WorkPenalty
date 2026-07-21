package net.philipp.workpenalty;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class WorkPenaltyModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            Integer repairCost = stack.get(DataComponents.REPAIR_COST);
            if (repairCost != null && repairCost > 0) {
                ChatFormatting color = repairCost >= 15 ? ChatFormatting.RED : ChatFormatting.GRAY;
                lines.add(Component.translatable("tooltip.workpenalty.work_penalty", repairCost)
                              .withStyle(color));
            }
        });
    }
}
