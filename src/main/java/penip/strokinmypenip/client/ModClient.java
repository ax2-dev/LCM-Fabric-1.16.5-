package penip.strokinmypenip.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;   // :contentReference[oaicite:0]{index=0}
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import penip.strokinmypenip.EntityRegistry;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(
                EntityRegistry.CUSTOM_XP_BOTTLE,
                (dispatcher, context) -> new FlyingItemEntityRenderer<>(
                        dispatcher,
                        context.getItemRenderer()
                )
        );

    }
}
