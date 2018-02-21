package com.munchkin.user.dto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

import com.munchkin.product.dto.SizeDto;
import com.munchkin.user.enums.Arm;
import com.munchkin.user.enums.BodyType;
import com.munchkin.user.enums.Gender;
import com.munchkin.user.enums.Shoulder;
import io.swagger.annotations.ApiModelProperty;

public class UserDto {

    @ApiModelProperty(required = true)
    private Gender gender;

    @ApiModelProperty(required = true)
    private BodyType bodyType;

    @ApiModelProperty(required = true)
    private int height;

    @ApiModelProperty(required = true)
    private Shoulder shoulder;

    @ApiModelProperty(required = true)
    private Arm arm;

    public UserDto() {
    }

    public UserDto(Gender gender, BodyType bodyType, int height, Shoulder shoulder, Arm arm) {
        this.gender = gender;
        this.bodyType = bodyType;
        this.height = height;
        this.shoulder = shoulder;
        this.arm = arm;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Shoulder getShoulder() {
        return shoulder;
    }

    public void setShoulder(Shoulder shoulder) {
        this.shoulder = shoulder;
    }

    public Arm getArm() {
        return arm;
    }

    public void setArm(Arm arm) {
        this.arm = arm;
    }

    public String getSize() {
        int score = 100;

        /* 성별, 키 */
        switch (gender) {
            case MAN:
                if (height < 160) {
                    score -= 24;
                } else if (height < 165) {
                    score -= 16;
                } else if (height < 170) {
                    score -= 8;
                } else if (height < 175) {
                } else if (height < 180) {
                    score += 8;
                } else if (height < 185) {
                    score += 16;
                } else {
                    score += 24;
                }
                break;
            case WOMAN:
                if (height < 150) {
                    score -= 24;
                } else if (height < 155) {
                    score -= 16;
                } else if (height < 160) {
                    score -= 8;
                } else if (height < 165) {
                } else if (height < 170) {
                    score += 8;
                } else if (height < 175) {
                    score += 16;
                } else {
                    score += 24;
                }
                break;
        }

        /* 체형 */
        switch (bodyType) {
            case THIN:
                score -= 6;
                break;
            case FAT:
                score += 6;
                break;
        }

        /* 어깨 */
        switch (shoulder) {
            case NARROW:
                score -= 4;
                break;
            case BROAD:
                score += 4;
                break;
        }

        /* 팔길이 */
        switch (arm) {
            case SHORT:
                score -= 2;
                break;
            case LONG:
                score += 2;
                break;
        }

/*        if (score < 70) {
            return "XS";
        } else if (score < 90) {
            return "S";
        }  else if (score < 110) {
            return "M";
        } else if (score < 130) {
            return "L";
        } else {
            return "XL";
        }*/
        return matchingSize(score);
    }

    public String matchingSize (int size) {
    	String matchingSize = null;
    	int xSmallVal = Math.abs(60 - size);
    	int smallVal = Math.abs(80 - size);
    	int mediumVal = Math.abs(100 - size);
    	int largeVal = Math.abs(120 - size);
    	int xLargeVal = Math.abs(140 - size);

    	SizeDto sizeVal = new SizeDto();
    	sizeVal.setXS(String.valueOf(xSmallVal));
    	sizeVal.setS(String.valueOf(smallVal));
    	sizeVal.setM(String.valueOf(mediumVal));
    	sizeVal.setL(String.valueOf(largeVal));
    	sizeVal.setXL(String.valueOf(xLargeVal));

    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(xSmallVal);
    	list.add(smallVal);
    	list.add(mediumVal);
    	list.add(largeVal);
    	list.add(xLargeVal);
    	Integer minVal = Collections.min(list);
    	   try{
		    	Object obj= sizeVal;
		    	for (Field field : obj.getClass().getDeclaredFields()){
		            field.setAccessible(true);
		            Object value=field.get(obj);
		            	if (minVal == Integer.parseInt(value.toString())){
		            		matchingSize = field.getName();
		            	}
		        }
    	   }catch(NumberFormatException e){
    		   System.out.println("여기는 안들어오겠지");
    	   }catch (Exception e){
	            e.printStackTrace();
	        }
    	   return matchingSize;
    }
}
