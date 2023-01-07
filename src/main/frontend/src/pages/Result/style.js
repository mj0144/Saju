import styled from "@emotion/styled";

export const ReslutContainer = styled.section`
    background-color: #F3B5BB;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;

`

export const Frame = styled.div`
    max-width: 600px;
    width: 100%;
    height: 100vh;
    background-color: #FBE8E7;
    margin: 6% auto 2%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 30px;
    text-align: center;
    border: 3px solid #9B6F73;
    

    & .titleWrap{
        &  h1{
            color: #9B6F73;
            font-size: 24px;
            font-weight: 900;
        }
    }

    & article{
        display: flex;
        flex-direction: row;
    }

    & .totalBox{
        border: 3px solid #9B6F73;
        background-color: #fff;
    }
`