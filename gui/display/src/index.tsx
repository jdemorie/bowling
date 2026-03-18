import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import {Provider} from "react-redux";
import {bowlingStore} from "./store/bowlingStore";

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <Provider store={bowlingStore}>
            <App/>
        </Provider>
    </React.StrictMode>
);