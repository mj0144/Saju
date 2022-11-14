import styled from '@emotion/styled';

export const InfoContainer = styled.section`
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
    
    & div{
        &  h1{
            color: #9B6F73;
            font-size: 24px;
            font-weight: 900;
        }
    }
   
`

export const FemailInfo = styled.div`
    border: 1px solid #A58187;
    width: 80%;
    padding: 10% 0;
    display: flex;
    justify-content: space-evenly;

    & figure{
        border: 1px solid #9B6F73;
        border-radius: 50%;
        box-sizing: border-box;
        background-color: #fff;
        padding: 6%;
    }

    & dl{
        display: flex;
        align-items: baseline;
    }

`


export const MalelInfo = styled.div`
    border: 1px solid #A58187;

`

export const SubmitForm = styled.form`


`