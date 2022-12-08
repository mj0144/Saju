import React, { useState } from "react";
import Title from "assets/images/title.png";
import Femail from "assets/images/femail.png";
import Male from "assets/images/male.png";
import { TimePicker } from "antd";
// import { BsPlus } from "@react-icons/all-files/bs/BsPlus";
import { InfoContainer, Frame, InsertInfo, SubmitForm } from "./style";

const Info = () =>{
    const [birthOne, setBirthOne] = useState(false);
    const [birthTwo, setBirthTwo] = useState(false);
    const [timeOne, setTimeOne] = useState(false);
    const [timeTwo, setTimeTwo] = useState(false);
    const [defaultCheckOne, setDefaultCheckOne] = useState(true);
    const [defaultCheckTwo, setDefaultCheckTwo] = useState(true);
    const [changeImgOne, setChangeImgOne] = useState(true);
    const [changeImgTwo, setChangeImgTwo] = useState(true);
    const [disOne, setDisOne] = useState(false);
    const [disTwo, setDisTwo] = useState(false);


    // 남/여 선택
    const checkedBoxOne = (e) => {
        const check = e.target.checked;
        const idx = e.target.id;

        if(check){
            switch(idx.includes("One")){
                case true: 
                return(
                        setDefaultCheckOne(!defaultCheckOne),
                        setChangeImgOne(!changeImgOne))
                    
                case false:
                    return(
                        setDefaultCheckTwo(!defaultCheckTwo),
                        setChangeImgTwo(!changeImgTwo)
                    )

                default:
                    return;
            }
        }

        // if(idx.includes("One")){
        //     if(check) {
        //         setDefaultCheckOne(!defaultCheckOne);
        //         setChangeImgOne(!changeImgOne);
        //     };
        // }

        // if(idx.includes("Two")){
        //     if(check) {
        //         setDefaultCheckTwo(!defaultCheckTwo);
        //         setChangeImgTwo(!changeImgTwo);
        //     };
        // }

    }

    // 태어난 시간 인풋 
    const changeTime = (e) => {
        const name = e.target.name;

        switch(name){
            case "timeOne":
                return setTimeOne(!timeOne);

            case "timeTwo":
                return setTimeTwo(!timeTwo);
                                
            default:
                return;
        }
    }

    // 생년월일 인풋
    const changeBirth = (e) => {
        const name = e.target.name;

        switch(name){
            case "birthOne":
                return setBirthOne(!birthOne);

            case "birthTwo":
                return setBirthTwo(!birthTwo);

            default:
                return;
        }
            
    }

    // 태어난 시간 disabled
    const changeDisabled = (e) => {
        const id = e.target.id;

        switch(id){
            case "femailBorn":
                return setDisOne(!disOne);
            
            case "maleBorn":
                return setDisTwo(!disTwo);

            default:
                return;
        }
    }

    // useEffect(() => {
    //     async function fetchData(){
    //         try{
    //             const data = await axios.post("http://localhost:8080/saju/v1.0/result/info");
    //             console.log(data)
    //         }catch(err){
    //             console.log(err)
    //         } 
            
    //     }
    //     fetchData();
    // }, [])

    // 이미지 업로드 함수
    // const clickUpLoad = (e) => {
    //     e.preventDefault();
    //     imgRef.current.click();
    // }

    // const onImgUpLoad = (e) => {
    //     const forData = new FormData();
    //     forData.append("profile", e.target.files[0]);
    //     // const res = axios.post("/api/upload", forData); // api 필요
    // }

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
                        {/* <input ref={imgRef} type="file" accept="image/*" name="file" style={{display: "none"}} onChange={onImgUpLoad} />
                        <span onClick={clickUpLoad} style={{visibility: "hidden"}}><BsPlus /></span> */}
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
                            {birthOne ? 
                                (<input type="date" />)
                                :
                                (<input type="text" name="birthOne" placeholder="생년월일" onClick={changeBirth} />)
                            }
                            </li>
                            <li>
                            {timeOne ? 
                                (
                                    <TimePicker 
                                        use12Hours 
                                        placeholder="H/M/S" 
                                        className={disOne ? "disabled" : ""}
                                        disabled={disOne ? true : false}
                                    />
                                ) 
                                :
                                (
                                    <input 
                                        type="text" 
                                        name="timeOne" 
                                        placeholder="태어난 시간" 
                                        onClick={changeTime} 
                                        disabled={disOne ? true : false} 
                                        className={disOne ? "disabled" : ""}
                                    />
                                )
                            }
                            </li>
                        </ul>
                    </SubmitForm>

                    <p className="noTime">
                        <input type="checkbox" id="femailBorn" onClick={changeDisabled}/>
                        <label htmlFor="femailBorn"></label>
                        <span>태어난 시간 모름</span>
                    </p>

                </InsertInfo>

                <InsertInfo>
                    <figure>
                        <img src={changeImgTwo ? Male : Femail} alt="Male" />
                        {/* <span style={{visibility: "hidden"}}><BsPlus /></span> */}
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
                            {birthTwo ? 
                                    (<input type="date" />)
                                    :
                                    (<input type="text" name="birthTwo" placeholder="생년월일" onClick={changeBirth} />)
                            }
                            </li>
                            <li>
                            {timeTwo ? 
                                (<TimePicker use12Hours placeholder="H/M/S" className={disTwo ? "disabled" : ""} />) 
                                :
                                (
                                    <input 
                                        type="text" 
                                        name="timeTwo" 
                                        placeholder="태어난 시간" 
                                        onClick={changeTime} 
                                        disabled={disTwo ? true : false}
                                        className={disTwo ? "disabled" : ""}
                                    />
                                )
                            }
                            </li>
                        </ul>
                    </SubmitForm>

                    <p className="noTime">
                        <input type="checkbox" id="maleBorn" onClick={changeDisabled} />
                        <label htmlFor="maleBorn"></label>
                        <span>태어난 시간 모름</span>
                    </p>

                </InsertInfo>

                <div className="resultBtn">
                    <button type="submit">결과보기</button>
                </div>
            </Frame>
        </InfoContainer>
    )
}

export default Info;