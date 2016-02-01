package net.dzikoysk.wildskript.register;

import ch.njol.skript.classes.SerializableGetter;
import ch.njol.skript.registrations.EventValues;
import net.dzikoysk.wildskript.events.skript.EvtJump;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EventValue {

    public static void registerEventValues() {

        List<Element> es = new ArrayList<>();

        es.add(new Element(Type.EVENT_VALUE).name("[On Enchant] event-item"));
        EventValues.registerEventValue(EnchantItemEvent.class, ItemStack.class, new SerializableGetter<ItemStack, EnchantItemEvent>() {
            public ItemStack get(EnchantItemEvent event) {
                return event.getItem();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Enchant] player"));
        EventValues.registerEventValue(EnchantItemEvent.class, Player.class, new SerializableGetter<Player, EnchantItemEvent>() {
            public Player get(EnchantItemEvent event) {
                return event.getEnchanter();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Inventory Click] event-item"));
        EventValues.registerEventValue(InventoryClickEvent.class, ItemStack.class, new SerializableGetter<ItemStack, InventoryClickEvent>() {
            public ItemStack get(InventoryClickEvent event) {
                return event.getCurrentItem();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Inventory Click] player"));
        EventValues.registerEventValue(InventoryClickEvent.class, Player.class, new SerializableGetter<Player, InventoryClickEvent>() {
            public Player get(InventoryClickEvent event) {
                return (Player) event.getWhoClicked();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Close Inventory] player"));
        EventValues.registerEventValue(InventoryCloseEvent.class, Player.class, new SerializableGetter<Player, InventoryCloseEvent>() {
            public Player get(InventoryCloseEvent event) {
                return (Player) event.getPlayer();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[Server Ping] IP"));
        EventValues.registerEventValue(ServerListPingEvent.class, String.class, new SerializableGetter<String, ServerListPingEvent>() {
            public String get(ServerListPingEvent event) {
                return event.getAddress().toString();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Jump] player"));
        EventValues.registerEventValue(EvtJump.class, Player.class, new SerializableGetter<Player, EvtJump>() {
            public Player get(EvtJump event) {
                return event.getPlayer();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Prepare Item Craft Event] player"));
        EventValues.registerEventValue(PrepareItemCraftEvent.class, Player.class, new SerializableGetter<Player, PrepareItemCraftEvent>() {
            public Player get(PrepareItemCraftEvent event) {
                return (Player) event.getView().getPlayer();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Prepare Item Craft Event] event-item"));
        EventValues.registerEventValue(PrepareItemCraftEvent.class, ItemStack.class, new SerializableGetter<ItemStack, PrepareItemCraftEvent>() {
            public ItemStack get(PrepareItemCraftEvent event) {
                return event.getRecipe().getResult();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Horse Jump] horse"));
        EventValues.registerEventValue(HorseJumpEvent.class, Horse.class, new SerializableGetter<Horse, HorseJumpEvent>() {
            public Horse get(HorseJumpEvent event) {
                return event.getEntity();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Book Edit] player"));
        EventValues.registerEventValue(PlayerEditBookEvent.class, Player.class, new SerializableGetter<Player, PlayerEditBookEvent>() {
            public Player get(PlayerEditBookEvent event) {
                return event.getPlayer();
            }
        }, 0);

        es.add(new Element(Type.EVENT_VALUE).name("[On Craft Item] event-item"));
        EventValues.registerEventValue(CraftItemEvent.class, ItemStack.class, new SerializableGetter<ItemStack, CraftItemEvent>() {
            public ItemStack get(CraftItemEvent event) {
                return event.getRecipe().getResult();
            }
        }, 0);

        RegisterManager.registerEventValues(es);

    }

}
