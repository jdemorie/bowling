import {useStartMutation} from "../../openapi/enhancedApi";
import {useCallback, useState} from "react";
import {useRookie} from "../../store/playerSlice";

export const useStartGame = () => {
    const [start] = useStartMutation();
    const rookie = useRookie();
    const [isGameStart, setGameStart] = useState(false);
    const [isStartSuccess, setStartSuccess] = useState(false);

    const startGame = useCallback((name: string, level?: string) => {
            setGameStart(true);
            start({
                body: [{
                    name: name,
                    rookie,
                }],
            }).unwrap().then((_) => {
                setStartSuccess(true);
            }).catch((reason => {
                setStartSuccess(false);
            })).finally(() => {
                setGameStart(false);
            });
        },
        [start, setGameStart, setStartSuccess, rookie],
    );
    return {startGame, isStartSuccess, isGameStart};
};