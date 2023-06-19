import { useState } from "react"

export default function App() {
    const [number, setNumber] = useState(0)

    function increase(){
        setNumber(number + 1)
    }

    function decrease(){
        setNumber(number - 1)
    }

    function reset(){
        setNumber(0)
    }

    return <section>
        <div id="counter">
            <div>
                <button className="count-button" onClick={decrease}>
                    -
                </button>
                <span id="value">
                    {number}
                </span>
                <button className="count-button" onClick={increase}>
                    +
                </button>
            </div>

            <button id="reset" onClick={reset}>
                Resetar
            </button>
        </div>
    </section>
}