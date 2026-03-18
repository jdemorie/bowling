import styled from "styled-components";
import {motion} from "motion/react";

export const CenterContainer = styled(motion.div)`
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: whitesmoke;
`;

export const Container = styled(motion.div)`
    position: relative;
    height: 100vh;
    width: 100vw;
    display: flex;
    justify-content: center;
    align-items: center;
`;

export const InputRowContainer = styled(motion.div)`
    position: absolute;
    z-index: 2;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    gap: 1rem;
`;

export const InputColumnContainer = styled(motion.div)`
    position: absolute;
    z-index: 2;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    gap: 1rem;
`;

export const Gif = styled(motion.img)`
    height: 100%;
    width: 100%;
`;

export const GifLaunching = styled(motion.img)`
    width: 50%;
    height: 50%;
    object-fit: contain;
    display: block;
    margin: auto
`;

export const StyledButton = styled(motion.button)`
    font-size: 16px;
    cursor: pointer;
    padding: 10px 20px;
`;

export const StyledErrorMessage = styled(motion.section)`
    display: flex;
    justify-content: center;
    align-items: center;
    color: red;
    height: 100%;
`;

export const StyledLabel = styled(motion.label)`
    color: white;
    display: block;
    margin: auto;
`

export const LabelLaunching = styled(motion.label)`
    color: white;
    margin: auto;
    font-size: 24px;
    font-weight: bold;
`;

export const StyledInput = styled(motion.input)`
    padding: 10px;
    font-size: 16px;
    width: 400px;
`;