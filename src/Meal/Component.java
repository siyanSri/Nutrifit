package Meal;

interface Component extends Iterable<Component> {
    void log();
}