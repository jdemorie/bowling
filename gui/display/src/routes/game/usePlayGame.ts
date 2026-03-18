import {usePlayMutation} from "../../openapi/enhancedApi";
import {useCallback, useState} from "react";

export const usePlayGame = () => {
    const [play] = usePlayMutation();
    const [isPlayStart, setPlayStart] = useState(false);
    const [isPlaySuccess, setPlaySuccess] = useState(false);
    const [getPinsDown, setPinsDown] = useState(0);

    const playGame = useCallback((name: string) => {
            setPlayStart(true);
            play({
                playerBean: {
                    name: name,
                },
            })
                .then(
                    (response) => {
                        setPlaySuccess(true);
                        setPinsDown(response.data === undefined ? 0 : response.data.pinsDown);
                    },
                    (reason) => {
                        setPlaySuccess(false);
                        setPinsDown(0);
                    },
                )
                .finally(() => {
                    setPlayStart(false);
                });
        },
        [play],
    );
    return {playGame, isPlaySuccess, isPlayStart, getPinsDown};
};