import React from 'react';
import {createBrowserRouter, Navigate, Outlet, RouterProvider} from "react-router";
import StartPage from "./routes/start/StartPage";
import ErrorElement from "./shared/ErrorElement";
import GamePage from "./routes/game/GamePage";
import {motion} from "motion/react"

const router = createBrowserRouter([
    {
        path: '/',
        element: <div><Outlet/></div>,
        children: [
            {
                index: true,
                element: <Navigate to="/start" replace={true}/>,
            },
            {
                path: 'start',
                element: <StartPage/>,
                errorElement: <ErrorElement/>,
                loader: () => {
                }
            },
            {
                path: 'game',
                element: <GamePage/>,
                errorElement: <ErrorElement/>,
                loader: () => {
                }
            }
        ]
    },
]);

function App() {
    return (
        <motion.div
            animate={{
                scale: 1,
                transition: {duration: 2}
            }} className="App">
            <RouterProvider router={router}/>
        </motion.div>
    );
}

export default App;
