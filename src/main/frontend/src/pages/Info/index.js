import React, { useRef, useState } from "react";
import Title from "assets/images/title.png";
import Femail from "assets/images/femail.png";
import Male from "assets/images/male.png";
import axios from "axios";
import { BsPlus } from "@react-icons/all-files/bs/BsPlus";
import { InfoContainer, Frame, InsertInfo, SubmitForm } from "./style";

const Info = () =>{
    const inputRef = useRef();
    const imgRef = useRef();
    const [checked, setChecked] = useState([]);
    const [defaultCheckOne, setDefaultCheckOne] = useState(true);
    const [defaultCheckTwo, setDefaultCheckTwo] = useState(true);
    const [maleCheck, setMaleCheck] = useState(false);
    const [changeImgOne, setChangeImgOne] = useState(true);
    const [changeImgTwo, setChangeImgTwo] = useState(true);


    // 남/여 선택
    const checkedBoxOne = (e, id) => {
        const check = e.target.checked;
        const val = e.target.value;
        const idx = e.target.id;

        if(idx.includes("One")){
            if(check) {
                setDefaultCheckOne(!defaultCheckOne);
                setChangeImgOne(!changeImgOne);
            };
        }

        if(idx.includes("Two")){
            if(check) {
                setDefaultCheckTwo(!defaultCheckTwo);
                setChangeImgTwo(!changeImgTwo);
            };
        }

    }
    
    // const checkedBoxTwo = (e) => {
    //     const check = e.target.checked;
    //     if(check) {
    //         setDefaultCheckTwo(!defaultCheckTwo);
    //         setChangeImg(!changeImg);
    //     };
    // }

    const checkingBox = (e) => {
        console.dir(e.target)
    }

    // const changeDisabled = (e) => {
    //     e.target.checked === true ? 
    // }

    const clickUpLoad = (e) => {
        e.preventDefault();
        imgRef.current.click();
    }

    const onImgUpLoad = (e) => {
        const forData = new FormData();
        forData.append("profile", e.target.files[0]);
        // const res = axios.post("/api/upload", forData); // api 필요
    }

    return (
        <InfoContainer>
            <Frame>
                <div className="titleWrap">
                    <h1>우리는 얼마나 잘맞을까?</h1>
                    <img src={Title} alt="Title"/>
                </div>

                <InsertInfo>
                    <figure>
                        <img src={changeImgOne ? Femail : Male} alt="Feamil"/>
                        <input ref={imgRef} type="file" accept="image/*" name="file" style={{display: "none"}} onChange={onImgUpLoad} />
                        <span onClick={clickUpLoad}><BsPlus /></span>
                    </figure>

                    <SubmitForm>
                        <dl>
                            <dt>
                                <label>성별</label>
                            </dt>
                            <dd>
                                <label>여</label>
                                <input 
                                    type="checkbox" 
                                    id="femailOne" 
                                    value="femail" 
                                    onChange={checkedBoxOne} 
                                    checked={defaultCheckOne ? true : false}  
                                    />
                                <label htmlFor="femailOne"></label>
                            </dd>
                            <dd>
                                <label>남</label>
                                <input 
                                    type="checkbox" 
                                    id="maleOne" 
                                    value="male"
                                    onChange={checkedBoxOne} 
                                    checked={defaultCheckOne ? false : true}
                                    />
                                <label htmlFor="maleOne"></label>
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
                                <input type="text" placeholder="태어난 시간" ref={inputRef}/>
                            </li>
                        </ul>
                       

                    </SubmitForm>

                    <p className="noTime">
                        <input type="checkbox" id="femailBorn"/>
                        <label htmlFor="femailBorn"></label>
                        <span>태어난 시간 모름</span>
                    </p>

                </InsertInfo>

                <InsertInfo>
                    <figure>
                        <img src={changeImgTwo ? Male : Femail} alt="Male" />
                        <span><BsPlus /></span>
                    </figure>

                    <SubmitForm>
                        <dl>
                            <dt>
                                <label>성별</label>
                            </dt>
                            <dd>
                                <label>여</label>
                                <input 
                                    type="checkbox" 
                                    id="femailTwo" 
                                    onChange={checkedBoxOne} 
                                    checked={defaultCheckTwo ? false : true} 

                                    />
                                <label htmlFor="femailTwo"></label>
                            </dd>
                            <dd>
                                <label>남</label>
                                <input 
                                    type="checkbox" 
                                    id="maleTwo" 
                                    onChange={checkedBoxOne} 
                                    checked={defaultCheckTwo ? true : false} 

                                    />
                                <label htmlFor="maleTwo"></label>
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
                                <input type="text" placeholder="태어난 시간" ref={inputRef}/>
                            </li>
                        </ul>
                    </SubmitForm>

                    <p className="noTime">
                        <input type="checkbox" id="maleBorn" />
                        <label htmlFor="maleBorn"></label>
                        <span>태어난 시간 모름</span>
                    </p>

                </InsertInfo>

                <div>
                    <button type="submit">결과보기</button>
                </div>
            </Frame>
        </InfoContainer>
    )
}

export default Info;