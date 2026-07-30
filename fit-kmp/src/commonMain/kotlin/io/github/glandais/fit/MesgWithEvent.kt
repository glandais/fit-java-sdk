// Hand-written multiplatform port of MesgWithEvent.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

// Propriétés et non getX()/setX() : les classes générées qui implémentent cette
// interface (EventMesg, LapMesg, SessionMesg…) émettent leurs accesseurs scalaires
// sous forme de `var` (conv_mesgs.py), et une `var` ne peut pas implémenter une
// paire de fonctions. Sur JVM, déclarer les deux entrerait de toute façon en
// collision de signature (getTimestamp).
interface MesgWithEvent {
    var timestamp: DateTime?
    var event: Event?
    var eventType: EventType?
    var eventGroup: Short?
}
