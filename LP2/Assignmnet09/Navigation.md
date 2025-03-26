# Salesforce Calculator App Guide

## Step 1: Open Salesforce Developer Console
1. Log in to Salesforce.
2. Click on your profile picture (top-right corner).
3. Select **"Developer Console"**.
4. This is where you will write your Apex code.

---

## Step 2: Create an Apex Class
1. In the **Developer Console**, go to **File → New → Apex Class**.
2. Name the class **CalculatorController**.
3. Copy and paste the following code:

```apex
public class CalculatorController {
    public Decimal num1 { get; set; }
    public Decimal num2 { get; set; }
    public Decimal result { get; set; }

    public void add() {
        result = num1 + num2;
    }

    public void subtract() {
        result = num1 - num2;
    }

    public void multiply() {
        result = num1 * num2;
    }

    public void divide() {
        if (num2 == 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'Cannot divide by zero'));
        } else {
            result = num1 / num2;
        }
    }

    public void square() {
        result = num1 * num1;
    }

    public void power() {
        result = Math.pow(num1, num2);
    }
}
```
4. Click **Save (Ctrl + S)**.

---

## Step 3: Create a Visualforce Page for UI
1. Go to **Setup (Gear Icon → Setup)**.
2. In the **Quick Find** box, type **Visualforce Pages** and click on it.
3. Click **New**.
4. Name it **CalculatorPage**.
5. Paste the following code:

```html
<apex:page controller="CalculatorController">
    <apex:form>
        <apex:pageBlock title="Calculator">
            <apex:pageBlockSection columns="1">
                <apex:inputText value="{!num1}" label="Number 1"/>
                <apex:inputText value="{!num2}" label="Number 2"/>
                
                <apex:commandButton value="Add" action="{!add}"/>
                <apex:commandButton value="Subtract" action="{!subtract}"/>
                <apex:commandButton value="Multiply" action="{!multiply}"/>
                <apex:commandButton value="Divide" action="{!divide}"/>
                <apex:commandButton value="Square" action="{!square}"/>
                <apex:commandButton value="Power" action="{!power}"/>
                
                <apex:outputText value="Result: {!result}" style="font-weight:bold; font-size:16px;"/>
            </apex:pageBlockSection>
        </apex:pageBlock>
    </apex:form>
</apex:page>
```
6. Click **Save**.

---

## Step 4: Test the Calculator App
1. Click **Preview** on the **Visualforce Page**.
2. The calculator page will open in a new tab.
3. Enter numbers and click buttons to see results.

---

## Next Steps
- You can add this Visualforce Page to a **Lightning App or a Tab** for easy access.
- If you want a modern UI, consider using **Lightning Web Components (LWC)**.

Let me know if you need help! 🚀

