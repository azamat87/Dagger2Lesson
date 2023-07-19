package kz.azamat.dagger2lesson



class Vehicle(
    private val wheels: List<IWheel>,
    private val engine: IEngine) {

    fun go() {
        wheels
        engine
    }

}

interface IEngine
class Engine: IEngine {}
class V8Engine: IEngine {}

interface IWheel
class Wheel: IWheel

fun main() {
    val vehicle = Vehicle(List(5){ Wheel() }, V8Engine())
    val vehicle2 = Vehicle(List(4){ Wheel() }, Engine())
    vehicle.go()
}