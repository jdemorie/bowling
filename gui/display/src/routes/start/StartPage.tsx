import React, {FC, useCallback, useEffect, useRef, useState} from "react";
import {Container, Gif, InputRowContainer, StyledButton, StyledInput, StyleSelect} from "../../shared/SharedStyles";
import {useNavigate} from "react-router";
import {useName, useSetName, useSetRookie} from "../../store/playerSlice";
import {useStartGame} from "./useStartGame";

const StartPage: FC = () => {
    const name = useName();
    const setRookie = useSetRookie();
    const setName = useSetName();
    const navigate = useNavigate();
    const inputRef = useRef<HTMLInputElement>(null);
    const {startGame, isStartSuccess} = useStartGame();
    const [selectedLevel, setSelectedLevel] = useState<string>("");

    const handleNameChange = useCallback((e: React.ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value);
    }, [setName]);

    const handleKeyDown = useCallback((e: React.KeyboardEvent<HTMLInputElement>) => {
        if (e.key === "Enter") {
            startGame(name);
        }
    }, [startGame, name]);

    const onStartGame = useCallback(() => {
        startGame(name);
    }, [startGame, name]);

    const handleSelectChange = useCallback((e: React.ChangeEvent<HTMLSelectElement>) => {
        const level = e.target.value;
        setSelectedLevel(level);
        if (level === "easy") {
            setRookie(0.5);
        }
        if (level === "medium") {
            setRookie(0.8);
        }
        if (level === "hard") {
            setRookie(1);
        }
    }, [setSelectedLevel, setRookie]);

    useEffect(() => {
        if (inputRef.current) {
            inputRef.current.focus();
        }
    }, []);

    useEffect(() => {
        if (isStartSuccess) {
            navigate("/game");
        }
    }, [navigate, isStartSuccess]);

    return (
        <Container initial={{scale: 0}} animate={{
            scale: 1,
            transition: {duration: 1}
        }}>
            <Gif src="/bowling.jpg" alt="Bowling GIF"/>
            <InputRowContainer animate={{
                scale: 1,
                transition: {duration: 2}
            }}>
                <StyledInput
                    ref={inputRef}
                    type="text"
                    value={name}
                    onChange={handleNameChange}
                    onKeyDown={handleKeyDown}
                    placeholder="Enter your name"
                    initial={{scale: 0}} animate={{scale: 1, transition: {duration: 1}}}
                />
                <StyleSelect value={selectedLevel} onChange={handleSelectChange}>
                    <option value="" disabled>Select skill level</option>
                    <option value="easy">Expert</option>
                    <option value="medium">Medium</option>
                    <option value="hard">Rookie</option>
                </StyleSelect>
                <StyledButton initial={{scale: 0}} animate={{scale: 1, transition: {duration: 1}}} onClick={onStartGame}>
                    Start New Game
                </StyledButton>
            </InputRowContainer>

        </Container>
    )
}

export default StartPage;