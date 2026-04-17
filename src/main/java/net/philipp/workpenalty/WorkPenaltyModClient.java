package net.philipp.workpenalty;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class WorkPenaltyModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            Integer repairCost = stack.get(DataComponentTypes.REPAIR_COST);
            if (repairCost != null && repairCost > 0) {
                Formatting color = repairCost >= 15 ? Formatting.RED : Formatting.GRAY;
                lines.add(Text.translatable("tooltip.workpenalty.work_penalty", repairCost)
                              .formatted(color));
            }
        });
    }
}
