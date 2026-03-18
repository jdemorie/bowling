import {usePlayMutation} from "../../openapi/enhancedApi";
import {useCallback, useState} from "react";
import {useRookie} from "../../store/playerSlice";

export const usePlayGame = () => {
    const [play] = usePlayMutation();
    const rookie = useRookie();
    const [isPlayStart, setPlayStart] = useState(false);
    const [isPlaySuccess, setPlaySuccess] = useState(false);
    const [getPinsDown, setPinsDown] = useState(0);
    const [gameOver, setGameOver] = useState(false);

    const playGame = useCallback((name: string) => {
            setPlayStart(true);
            play({
                playerBean: {
                    name: name,
                    rookie
                },
            }).unwrap().then((response) => {
                setPlaySuccess(true);
                setPinsDown(response === undefined ? 0 : response.pinsDown);
            }).catch((reason) => {
                const {errorCode} = reason.data;
                if (errorCode === 1401) {
                    setGameOver(true);
                } else {
                    setPlaySuccess(false);
                }
                setPinsDown(0);
            }).finally(() => {
                setPlayStart(false);
            });
        },
        [play, setGameOver, setPlayStart, setPlaySuccess, setPinsDown, rookie],
    );
    return {playGame, isPlaySuccess, isPlayStart, gameOver, getPinsDown};
};