import React from "react";
import Title from "assets/images/title.png";
import Femail from "assets/images/femail.png";
import Male from "assets/images/male.png";
import { InfoContainer, Frame, FemailInfo, MalelInfo, SubmitForm } from "./style";

const Info = () =>{

    return (
        <InfoContainer>
            <Frame>
                <div>
                    <h1>우리는 얼마나 잘맞을까?</h1>
                    <img src={Title} alt="Title"/>
                </div>

                <FemailInfo>
                    <figure>
                        <img src={Femail} alt="Feamil"/>
                    </figure>

                    <SubmitForm>
                        <dl>
                            <dt>
                                <label>성별</label>
                            </dt>
                            <dd>
                                <label>여</label>
                                <input type="checkbox"/>
                            </dd>
                            <dd>
                                <label>남</label>
                                <input type="checkbox"/>
                            </dd>
                        </dl>
                        <ul>
                            <li>
                                <input type="text" placeholder="이름"/>
                            </li>
                            <li>
                                <input type="text" placeholder="생년월일"/>
                            </li>
                            <li>
                                <input type="text" placeholder="출생시간"/>
                            </li>
                        </ul>
                    </SubmitForm>
                    
                </FemailInfo>

                <MalelInfo>
                    <figure>
                        <img src={Male} alt="Male" />
                    </figure>
                </MalelInfo>
            </Frame>
        </InfoContainer>
    )
}

export default Info;